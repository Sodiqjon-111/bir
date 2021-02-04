package com.example.newtest

object Constants {
     const val Name:String="name"
     fun getQuestions():ArrayList<Question>{
         val questionList=ArrayList<Question>()
         val  que1=Question(1,"2*2= _ ",
             "8",
             "12",
             "45",
             "4",
             4)
           questionList.add(que1);
         val  que2=Question(2,"45-10= _ ",
             "8",
             "12",
             "45",
             "35",
             4)
         questionList.add(que2);
         val  que3=Question(3,"30/15= _ ",
             "8",
             "2",
             "45",
             "4",
             2)
         questionList.add(que3);
         val  que4=Question(4,"2*20= _ ",
             "40",
             "12",
             "45",
             "4",
             1)
         questionList.add(que4);
         val  que5=Question(5,"100/20= _ ",
             "5",
             "12",
             "45",
             "4",
             1)
         questionList.add(que5);
         val  que6=Question(6,"200-100=  _   ",
             "100",
             "12",
             "150",
             "300",
             1)
         questionList.add(que6);
         val  que7=Question(7,"48-20= _ ",
             "33",
             "12",
             "28",
             "72",
             3)
         questionList.add(que7);
         val  que8=Question(8,"85-30= _ ",
             "25",
             "12",
             "36",
             "50",
             4)
         questionList.add(que8);
         val  que9=Question(9,"80/40= _  ",
             "14",
             "12",
             "2",
             "4",
             3)
         questionList.add(que9);
         val  que10=Question(10,"500-400= _ ",
             "150",
             "12",
             "100",
             "4",
             3)
         questionList.add(que10);
         return  questionList
     }
}