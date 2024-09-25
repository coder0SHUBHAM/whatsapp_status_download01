package com.devatrii.statussaver.views.adapters

import android.app.ActionBar
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devatrii.statussaver.R
import com.devatrii.statussaver.databinding.DialogGuideBinding
import com.devatrii.statussaver.databinding.ItemSettingsBinding
import com.devatrii.statussaver.models.SettingsModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SettingsAdapter(var list: ArrayList<SettingsModel>, var context: Context) :
    RecyclerView.Adapter<SettingsAdapter.viewHolder>() {

    inner class viewHolder(var binding: ItemSettingsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SettingsModel, position: Int) {
            binding.apply {
                settingsTitle.text = model.title
                settingsDesc.text = model.desc

                root.setOnClickListener {
                    when (position) {
                        0 -> {
                            // how to use 1st item
                            val dialog = Dialog(context)
                            val dialogBinding =
                                DialogGuideBinding.inflate((context as Activity).layoutInflater)
                            dialogBinding.okayBtn.setOnClickListener {
                                dialog.dismiss()
                            }
                            dialog.setContentView(dialogBinding.root)

                            dialog.window?.setLayout(
                                ActionBar.LayoutParams.MATCH_PARENT,
                                ActionBar.LayoutParams.WRAP_CONTENT
                            )

                            dialog.show()


                        }

                        2 -> {
                            MaterialAlertDialogBuilder(context).apply {
                                setTitle("Disclaimer")
                                setMessage("Disclaimer Here : " + "\n" +
                                        "1.This app is developed by Shubham Sonar and is not affiliated with, endorsed, or sponsored by WhatsApp Inc. WhatsApp is a trademark of WhatsApp Inc. and is owned by Facebook.\n" +
                                        "\n" +
                                        "2.The app is designed to help users download and save media from WhatsApp statuses for personal use only. Users are advised to seek permission from the original content creator before downloading or sharing any content.\n" +
                                        "\n" +
                                        "3.Shubham Sonar and this app are not responsible for any misuse of the downloaded content or any violations of copyright laws. Users are solely responsible for any legal consequences of using this app.\n" +
                                        "\n" +
                                        "4.By using this app, you agree to comply with all applicable laws and respect others' privacy and intellectual property rights.")
                                setPositiveButton("Okay",null)
                                show()
                            }
                        }

                        3 -> {
                            MaterialAlertDialogBuilder(context).apply {
                                setTitle("Privacy Policy")
                                setMessage("Privacy Policy : " + "\n" +
                                        "1. Introduction\n" +
                                        "This Privacy Policy explains how your information is collected, used, and shared when you use the WhatsApp Status Download app (\"the App\"). The App is developed by Shubham Sonar (\"we,\" \"our,\" or \"us\"). By using the App, you agree to the practices described in this Privacy Policy.\n" +
                                        "\n" +
                                        "2.We do not collect personal information directly from users. However, the app may request access to your device’s storage and media files in order to download and save WhatsApp statuses.\n" +
                                        "\n" +
                                        "3.We do not share your data with third parties. However, the app may contain links to third-party websites (e.g., Google Play Store). We are not responsible for the privacy practices of such third-party services.\n" +
                                        "\n" +
                                        "4.We prioritize the security of your information. We use industry-standard security measures to ensure that your data is protected when using our app. However, no method of transmission or electronic storage is 100% secure.\n" +
                                        "\n" +
                                        "5.We may update this Privacy Policy from time to time. Any changes will be posted within the app, and the date of the last revision will be updated at the top of this policy.\n" +
                                        "\n" +
                                        "6. Contact Us\n" +
                                        "If you have any questions or concerns about this Privacy Policy or how your data is handled, please contact us at:\n" +

                                        "Email: [shubhamsonar909@gmail.com]\n" +
                                        "\n")
                                setPositiveButton("Okay",null)
                                show()
                            }
                        }


                        4 -> {
                        Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_SUBJECT,context.getString(R.string.app_name))
                            putExtra(Intent.EXTRA_TEXT,"My App is soo cool please download it :https://play.google.com/store/apps/details?id=${context.packageName}")
                            context.startActivity(this)
                        }
                        }


                    }
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(ItemSettingsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(model = list[position], position)
    }
}