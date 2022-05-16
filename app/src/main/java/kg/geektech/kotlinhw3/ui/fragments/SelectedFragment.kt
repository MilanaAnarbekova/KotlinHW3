package kg.geektech.kotlinhw3.ui.fragments

import android.view.LayoutInflater
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kg.geektech.kotlinhw3.base.BaseFragment
import kg.geektech.kotlinhw3.base.BaseViewModel
import kg.geektech.kotlinhw3.data.model.Pictures
import kg.geektech.kotlinhw3.databinding.SelectedFragBinding
import kg.geektech.kotlinhw3.ui.adapters.AdapterGallery

class SelectedFragment: BaseFragment<SelectedFragBinding, BaseViewModel>() {

    private val photoAdapter = AdapterGallery()
    private val viewModels: SelectedViewModel by activityViewModels()
    private var list = arrayListOf<Pictures>()

    override fun inflateViewBinding(inflater: LayoutInflater): SelectedFragBinding {
        return SelectedFragBinding.inflate(inflater)
    }

    override fun initView() {
       binding.recyclerView.adapter = photoAdapter
        viewModels.listState.observe(this, Observer {
            photoAdapter.setList(it)
        })
    }

    override fun initListener() {
        binding.btnBack.setOnClickListener{
            requireActivity().onBackPressed()
        }
    }


}