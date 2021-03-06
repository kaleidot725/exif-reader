package kaleidot725.exifreader.ui.home

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.HomeFragmentBinding
import kaleidot725.exifreader.extention.dataBinding
import org.koin.android.viewmodel.ext.android.viewModel
import pub.devrel.easypermissions.EasyPermissions

class HomeFragment : Fragment(R.layout.home_fragment), EasyPermissions.PermissionCallbacks {
    private val navController: NavController get() = findNavController()
    private val homeViewModel: HomeViewModel by viewModel()
    private val _binding: HomeFragmentBinding? by dataBinding()
    private val binding: HomeFragmentBinding get() = _binding!!
    private lateinit var recyclerAdapter: PictureAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVariable()
        setupView()
        setupObserver()
        checkPermission()
    }

    private fun setupVariable() {
        recyclerAdapter = PictureAdapter(viewLifecycleOwner).apply {
            onClick = { picture ->
                val action = HomeFragmentDirections.actionHomeFragmentToViewerFragment(picture.path)
                navController.navigate(action)
            }
        }
    }

    private fun setupView() {
        binding.vm = homeViewModel
        binding.pictureRecyclerView.apply {
            this.adapter = recyclerAdapter
            this.layoutManager = GridLayoutManager(context, 3)
            this.setHasFixedSize(true)
        }
    }

    private fun setupObserver() {
        homeViewModel.pictures.observe(viewLifecycleOwner) {
            recyclerAdapter.update(it)
        }
    }

    private fun checkPermission() {
        val permission = Manifest.permission.READ_EXTERNAL_STORAGE
        if (!EasyPermissions.hasPermissions(requireContext(), permission)) {
            EasyPermissions.requestPermissions(
                this,
                "This Application Access External Storage. Are you OK",
                0,
                permission
            )
        } else {
            homeViewModel.updateAccessible(true)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, list: List<String>) {
        homeViewModel.updateAccessible(true)
    }

    override fun onPermissionsDenied(requestCode: Int, list: List<String>) {
        homeViewModel.updateAccessible(false)
    }
}