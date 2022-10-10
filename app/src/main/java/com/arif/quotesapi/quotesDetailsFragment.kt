package com.arif.quotesapi
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment

import com.arif.quotesapi.databinding.FragmentQuotesDetailsBinding
import org.w3c.dom.Text


class quotesDetailsFragment : Fragment() {
    private lateinit var binding:FragmentQuotesDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuotesDetailsBinding.inflate(inflater,container,false)
        val bundle = arguments
        val quoteInfo = bundle?.getString("text_info")
        val quoteInfo2 = bundle?.getString("auth_info")
        binding.quotesTV.text = quoteInfo
        binding.authTV.text = quoteInfo2
        val quotes = "$quoteInfo\n-$quoteInfo2"
        Log.d("Details", "onCreateView: $quotes")

        binding.copyBtn.setOnClickListener{
            var myClipboard = getSystemService(requireContext(), ClipboardManager::class.java) as ClipboardManager
            val clip = ClipData.newPlainText("Copied",quotes)
            myClipboard.setPrimaryClip(clip)
            Toast.makeText(requireActivity(), "Copied", Toast.LENGTH_SHORT).show()
        }
        binding.shareBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, quotes)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share Via"))
        }

        return binding.root
    }

}