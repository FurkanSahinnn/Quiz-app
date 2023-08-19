package eu.tutorials.quizapp

object Questions {
    fun getQuestion() : ArrayList<QuestionSettings> {
        val questionList = ArrayList<QuestionSettings>()

        val questionOne = QuestionSettings(
            1,
            "What is the most abundant cell in the human brain?",
            R.drawable.glialandneurons,
            "Glial Cells",
            "Neuron Cells",
            "Animal Cells",
            "Ovule",
            1 // OptionOne = 1
        )

        val questionTwo = QuestionSettings(
            2,
            "What is the reflex, causing hairs to stand on end, which no longer serves a significant purpose due to modern life?",
            R.drawable.reflexquestion,
            "Patellar Reflex",
            "Cornea Reflex",
            "Sneezing Reflex",
            "Piloerection Reflex",
            4
        )

        val questionThree = QuestionSettings(
            3,
            "In alcohol, which molecules increase the activity of which neuron to cause intoxication?",
            R.drawable.ethanolstructure,
            "Noradrenergic Neurons",
            "Pyramidal Neurons",
            "Gaba Neurons",
            "Dopaminergic Neurons",
            3
        )

        val questionFour = QuestionSettings(
            4,
            "Which brain lobe is responsible for processing perception and sensory experience in the human body?",
            R.drawable.brainlobes,
            "Frontal Lobe",
            "Parietal Lobe",
            "Temporal Lobe",
            "Occipital Lobe",
            2
        )

        val questionFive = QuestionSettings(
            5,
            "Which region in the temporal lobe is actively used for forming coherent sentences and understanding spoken language?",
            R.drawable.speaking,
            "Cerebral Cortex",
            "Broca's Area",
            "Wernicke's Area",
            "Heschl's Gyrus",
            3
        )

        questionList.add(questionOne)
        questionList.add(questionTwo)
        questionList.add(questionThree)
        questionList.add(questionFour)
        questionList.add(questionFive)

        return questionList
    }
}
