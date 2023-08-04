package com.example.composition.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.composition.R
import com.example.composition.databinding.FragmentGameFinishedBinding
import com.example.composition.domain.entity.GameResult
import com.example.composition.domain.entity.GameSettings

class GameFinishedFragment: Fragment() {

    private lateinit var gameResult: GameResult
    private val args by navArgs<GameFinishedFragmentArgs>()

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("GameFinishedFragment", "onCreateView")
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        gameResult = args.gameResult
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("GameFinishedFragment", "onAttach")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonRetry.setOnClickListener{
            retryGame()
        }
        initViews()
    }

    private fun initViews() {
        binding.gameResult = gameResult
    }


    override fun onStart() {
        super.onStart()
        Log.d("GameFinishedFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("GameFinishedFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("GameFinishedFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("GameFinishedFragment", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("GameFinishedFragment", "onDestroy")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("GameFinishedFragment", "onDetach")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("GameFinishedFragment", "onDestroyView")

    }

    private fun retryGame() {
        findNavController().popBackStack()
    }

    companion object {

        const val KEY_GAME_RESULT = "game_result"

        fun newInstance(gameResult: GameResult):  GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT, gameResult)
                }
            }
        }
    }
}