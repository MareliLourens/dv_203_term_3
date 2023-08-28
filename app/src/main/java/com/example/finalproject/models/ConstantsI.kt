package com.example.finalproject.models

object ConstantsI {

    var Inazuma_Questions = ArrayList<Question>()


    //function to populate our questions
    fun getAllQuestionsI() {

        val que1 = Question(
            1,
            "What element is associated with Inazuma?",
            "Anemo",
            "Pyro",
            "Hydro",
            "Electro",
            "Electro"
        )

        val que2 = Question(
            2,
            "Who is Inazuma’s archon?",
            "Zhongli",
            "Venti",
            "Raiden Shogun",
            "Kamisato Ayaka",
            "Raiden Shogun"
        )

        val que3 = Question(
            3,
            "Who is the head of the Kamisato Clan?",
            "Arataki Itto",
            "Kujou Sara",
            "Ayato",
            "Thoma",
            "Ayato"
        )

        val que4 = Question(
            4,
            "Where does Yae Miko reside?",
            "The Tenshukaku",
            "Grand Narukami Shrine",
            "Komore Teahouse",
            "Watatsumi Island",
            "Grand Narukami Shrine"
        )

        val que5 = Question(
            5,
            "Who is the general of the resistance?",
            "Gorou",
            "Sangonomiya Kokomi",
            "Arataki Itto",
            "Teppei",
            "Gorou"
        )

        Inazuma_Questions.clear()
        Inazuma_Questions.add(que1)
        Inazuma_Questions.add(que2)
        Inazuma_Questions.add(que3)
        Inazuma_Questions.add(que4)
        Inazuma_Questions.add(que5)

    }
}