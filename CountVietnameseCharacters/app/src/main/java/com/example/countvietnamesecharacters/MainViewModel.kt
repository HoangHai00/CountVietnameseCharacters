package com.example.countvietnamesecharacters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val result = MutableLiveData<String>()
    val isButtonClicked = MutableLiveData<Boolean>()

    init {
        isButtonClicked.value = false
    }

    fun countVietnameseCharacters(inputString: String) {
        if (isButtonClicked.value == true) {
            val telexMappings = mapOf(
                "aw" to 'ă',
                "aa" to 'â',
                "dd" to 'đ',
                "ee" to 'ê',
                "oo" to 'ô',
                "ow" to 'ơ',
                "w" to 'ư'
            )

            var count = 0
            var i = 0
            while (i < inputString.length) {
                var found = false
                for ((telex, char) in telexMappings) {
                    if (inputString.substring(i).startsWith(telex)) {
                        count++
                        i += telex.length
                        found = true
                        break
                    }
                }
                if (!found) {
                    i++
                }
            }

            result.value = "Số lượng chữ cái tiếng viêt: ${count}"
        }
    }
}