package kg.geektech.kotlinhw3.ui.fragments

import android.view.LayoutInflater
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import kg.geektech.kotlinhw3.R
import kg.geektech.kotlinhw3.base.BaseFragment
import kg.geektech.kotlinhw3.base.BaseViewModel
import kg.geektech.kotlinhw3.common.extension.navigateSafely
import kg.geektech.kotlinhw3.data.model.Pictures
import kg.geektech.kotlinhw3.databinding.GalleryFragBinding
import kg.geektech.kotlinhw3.ui.adapters.AdapterGallery

class GalleryFragment : BaseFragment<GalleryFragBinding, BaseViewModel>() {

    private val photoAdapter = AdapterGallery()
    private val viewModels: SelectedViewModel by activityViewModels()
    private var list = arrayListOf<Pictures>()

    override fun inflateViewBinding(inflater: LayoutInflater): GalleryFragBinding {
        return GalleryFragBinding.inflate(inflater)
    }

    override fun initView() {
        initAdapter()
        list.apply {
            add(Pictures("https://i.pinimg.com/236x/d8/e9/e5/d8e9e501621bfd6c1e13bddffdb5f249.jpg"))
            add(Pictures("https://i.pinimg.com/236x/f7/92/b6/f792b6bb812de893923f569b12961461.jpg"))
            add(Pictures("https://i.pinimg.com/236x/b0/1b/43/b01b436f7a66460a3aa5daa20f2c94f6.jpg"))
            add(Pictures("https://i.pinimg.com/564x/b0/05/b0/b005b0bd05592fdb7db29b32b28f478b.jpg"))
            add(Pictures("https://i.pinimg.com/564x/72/40/f7/7240f78a494d2623c546935cd2a789bc.jpg"))
        }
        photoAdapter.setList(list)
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = photoAdapter
    }

    override fun initListener() {
        binding.btnSend.setOnClickListener{
            findNavController().navigateSafely(R.id.action_galleryFragment_to_selectedFragment)
            viewModels.putPicture(photoAdapter.selectedList)
        }
    }
}