package com.example.candyspaceapps.model.view.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels

import com.example.candyspaceapps.databinding.FraUsersBinding
import com.example.candyspaceapps.model.data.UserItem
import com.example.candyspaceapps.model.view.adapter.UserAdapter
import com.example.candyspaceapps.util.ResponseStatus
import com.example.candyspaceapps.util.displayErrorMessage
import org.koin.androidx.viewmodel.ext.android.viewModel

//binding and using recyclerView
class UsersInfoFra : Fragment() {

    private val infoBinding by lazy{
        FraUsersBinding.inflate(layoutInflater)
    }
    //private val infoViewModel: UserModel by viewModel()
    private val infoViewModel: UserModel by viewModel()

    //adapter
    private lateinit var infoAdapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //setting adapter
        infoAdapter= UserAdapter()
        infoBinding.mainRecyclerViewUsers.adapter = infoAdapter
        infoViewModel.usersLiveData.observe(viewLifecycleOwner, { response ->
            // status of response: Loading, Success or Error
            when (response) {
                is ResponseStatus.SUCCESS -> {
                    infoBinding.progressBar.visibility= View.GONE
                    val usersList=response.success as UserItem
                    infoAdapter.loadData(usersList.userDetails)
                }
                is ResponseStatus.LOADING -> {infoBinding.progressBar.visibility= View.VISIBLE}
                is ResponseStatus.ERROR -> {
                    infoBinding.progressBar.visibility= View.GONE
                    displayErrorMessage(infoBinding.root,response.error.localizedMessage.toString())
                }
            }
        })
        //on click listener
        infoBinding.searchB.setOnClickListener{
            infoViewModel.signUpUsers(infoBinding.searchE.text.toString())
        }
        infoViewModel.signUpUsers(infoBinding.searchE.text.toString())

        return infoBinding.root
    }
}