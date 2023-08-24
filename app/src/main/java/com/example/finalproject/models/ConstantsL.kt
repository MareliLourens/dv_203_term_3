package com.example.finalproject.models

object ConstantsL {

    var Liyue_Questions = ArrayList<Question>()


    //function to populate our questions
    fun getAllQuestionsL() {

        val que1 = Question(
            1,
            "What element is associated with Liyue?",
            "Geo",
            "Pyro",
            "Hydro",
            "Electro",
            "Geo"
        )

        val que2 = Question(
            2,
            "Who is Liyue’s archon?",
            "Zhongli",
            "Venti",
            "Raiden Shogun",
            "Ningguang",
            "Zhongli"
        )

        val que3 = Question(
            3,
            "Who is the leader of the Liyue Qixing?",
            "Ningguang",
            "Beidou",
            "Keqing",
            "Ganyu",
            "Ningguang"
        )

        val que4 = Question(
            4,
            "What is the adeptus Xiao's former name?",
            "Alatus",
            "Scaramouche",
            "Zhongli",
            "Cloud Retainer",
            "Alatus"
        )

        val que5 = Question(
            5,
            "Who is the owner of Bubu Pharmacy?",
            "Baizhu",
            "Qiqi",
            "Xiangling",
            "Beidou",
            "Baizhu"
        )

        Liyue_Questions.add(que1)
        Liyue_Questions.add(que2)
        Liyue_Questions.add(que3)
        Liyue_Questions.add(que4)
        Liyue_Questions.add(que5)
    }

}