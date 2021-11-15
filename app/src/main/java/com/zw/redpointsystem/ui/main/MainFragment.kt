package com.zw.redpointsystem.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.zw.redpointsystem.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.systemNum.observe(viewLifecycleOwner){
            view.findViewById<TextView>(R.id.tv_message_system).text = it.toString()
        }

        viewModel.friendNum.observe(viewLifecycleOwner){
            view.findViewById<TextView>(R.id.tv_message_friend).text = it.toString()
        }

        viewModel.otherNum.observe(viewLifecycleOwner){
            view.findViewById<TextView>(R.id.tv_message_other).text = it.toString()
        }

        viewModel.totalNum.observe(viewLifecycleOwner){
            view.findViewById<TextView>(R.id.tv_message_all).text = it.toString()
        }

        view.findViewById<Button>(R.id.bt_add_system).setOnClickListener {
            //系统消息加
            viewModel.systemNum.value = viewModel.systemNum.value!!+1
        }

        view.findViewById<Button>(R.id.bt_reduce_system).setOnClickListener {
            //系统消息减
            if (viewModel.systemNum.value!! > 0){
                viewModel.systemNum.value = viewModel.systemNum.value!!-1
            }
        }

        view.findViewById<Button>(R.id.bt_add_friend).setOnClickListener {
            //好友消息加
            viewModel.friendNum.value = viewModel.friendNum.value!!+1
        }

        view.findViewById<Button>(R.id.bt_reduce_friend).setOnClickListener {
            //好友消息减
            if (viewModel.friendNum.value!! > 0){
                viewModel.friendNum.value = viewModel.friendNum.value!!-1
            }
        }

        view.findViewById<Button>(R.id.bt_add_other).setOnClickListener {
            //其他消息加
            viewModel.otherNum.value = viewModel.otherNum.value!!+1
        }

        view.findViewById<Button>(R.id.bt_reduce_other).setOnClickListener {
            //其他消息减
            if (viewModel.otherNum.value!! > 0){
                viewModel.otherNum.value = viewModel.otherNum.value!!-1
            }
        }

        view.findViewById<Button>(R.id.bt_clear).setOnClickListener {
            viewModel.clear()
        }

    }

}