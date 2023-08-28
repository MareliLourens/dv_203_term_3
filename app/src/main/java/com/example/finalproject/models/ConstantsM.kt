package com.example.finalproject.models

object ConstantsM {

    //array for our questions
    var Mondstadt_Questions = ArrayList<Question>()


    //function to populate our questions
    fun getAllQuestionsM() {

        val que1 = Question(
            1,
        "What element is associated with Mondstadt?",
        "Anemo",
        "Pyro",
        "Hydro",
        "Electro",
        "Anemo"
        )

        val que2 = Question(
            2,
            "Who is Mondstadt’s archon?",
            "Zhongli",
            "Venti",
            "Raiden Shogun",
            "Jean",
            "Venti"
        )

        val que3 = Question(
            3,
            "Who is considered a knight of favonius?",
            "Mona",
            "Kaeya",
            "Diluc",
            "Bennett",
            "Kaeya"
        )

        val que4 = Question(
            4,
            "Who is the main villain in the region?",
            "Scaramouche",
            "Tartaglia",
            "Dvalin",
            "Paimon",
            "Dvalin"
        )

        val que5 = Question(
            5,
            "What is Razor's level-up material?",
            "Wolfhook",
            "Valberries",
            "Cecilias",
            "Dandelion Seeds",
            "Wolfhook"
        )

        Mondstadt_Questions.clear()
        Mondstadt_Questions.add(que1)
        Mondstadt_Questions.add(que2)
        Mondstadt_Questions.add(que3)
        Mondstadt_Questions.add(que4)
        Mondstadt_Questions.add(que5)


    }
}