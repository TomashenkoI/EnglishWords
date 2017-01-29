package com.example.a7.englishwords;

public class Words {

    private String russianWord;
    private EnglishWords englishWords;

    private String[] russianWords = {"Ломать(ся)", "Приносить", "Строить", "Гореть, сжигать", "Покупать",
            "Уметь, мочь", "Ловить", "Выбирать", "Падать", "Кормить", "Приходить", "Стоить",
            "Ползать, красться", "Резать" , "Делать", "Рисовать", "Мечтать, видеть сны", "Пить",
            "Ехать, везти", "Есть, поедать", "Драться, сражаться", "Находить", "Летать", "Запрещать",
            "Забывать", "Получать, становиться", "Давать", "Идти", "Расти, вырастать",
            "Вешать, висеть", "Прятать(ся)", "Ударять", "Держать, проводить", "Причинять боль",
            "Хранить", "Стоять на коленях", "Знать", "Класть(прокладывать, лежать, возложить)",
            "Вести, руководить", "Учить", "Покидать", "Давать взаймы", "Позволять", "Лежать",
            "Зажигать свет", "Терять", "Делать(производить)", "Означать", "Встречать", "Быть должным",
            "Платить", "Класть(ставить, помещать)", "Бросать, прекращать", "Читать", "Ехать верхом",
            "Звонить", "Вставать", "Бежать", "Сказать", "Видеть", "Искать, разыскивать", "Продавать",
            "Посылать", "Ставить", "Шить", "Трясти", "Светить", "Стрелять", "Показывать", "Закрывать",
            "Петь", "Тонуть", "Сидеть", "Спать", "Скользить", "Чувствовать запах", "Говорить",
            "Мчаться", "Произносить по буквам, заколдовывать", "Тратить"};

    private String[] infinitiveWords = {"break", "bring", "build", "burn", "buy", "can", "catch", "choose", "fall",
            "feed", "come", "cost", "creep", "cut", "do", "draw", "dream","drink", "drive", "eat",
            "fight", "find", "fly", "forbid", "forget", "get", "give", "go","grow", "hang", "hide",
            "hit", "hold", "hurt", "keep", "kneel", "know", "lay", "lead", "learn", "leave", "lend",
            "let", "lie", "light", "lose", "make", "mean", "meet", "must", "pay", "put", "quit",
            "read", "ride", "ring", "rise", "run", "say", "see", "seek", "sell", "send", "set",
            "sew", "shake", "shine", "shoot", "show", "shut", "sing", "sink", "sit", "sleep",
            "slide", "smell", "speak", "speed", "spell", "spend"};

    private String[] pastSimpleWords = {"broke", "brought", "built", "burnt", "bought", "could", "caught", "chose",
            "fell", "fed", "came", "cost", "crept", "cut", "did", "drew", "dreamt","drank", "drove",
            "ate", "fought", "found", "flew", "forbade", "forgot", "got", "gave","went","grew",
            "hung", "hid", "hit", "held", "hurt", "kept", "knelt", "knew", "laid", "led", "learnt",
            "left", "lent", "let", "lay", "lit", "lost", "made", "meant", "met", "had to", "paid",
            "put", "quit", "read", "rode", "rang", "rose", "ran", "said", "saw", "sought", "sold",
            "sent", "set", "sewed", "shook", "shone", "shot", "showed", "shut", "sang", "sank",
            "sat", "slept","slid", "smelt", "spoke", "sped", "spelt", "spent"};

    private String[] pastParticularWords = {"broken", "brought", "built", "burnt", "bought", "been able", "caught",
            "chosen", "fallen", "fed", "come", "cost", "crept", "cut", "done", "drawn", "dreamt",
            "drunk", "driven", "eaten", "fought", "found", "flown", "forbidden", "forgotten", "got",
            "given","gone","grown", "hung", "hidden", "hit", "held", "hurt", "kept", "knelt", "known",
            "laid", "led", "learnt", "left", "lent", "let", "lain", "lit", "lost", "made", "meant",
            "met", "had to", "paid", "put", "quit", "read", "ridden", "rung", "risen", "run", "said",
            "seen", "sought", "sold", "sent", "set", "sewn", "shaken", "shone", "shot", "shown",
            "shut", "sung", "sunk", "sat", "slept", "slid", "smelt", "spoken", "sped", "spelt", "spent"};

    public Words() {
        getRandomWord();
    }

    private void getRandomWord(){

        int randomNumber = (int) (Math.random() * russianWords.length);

        this.russianWord = russianWords[randomNumber];

        String infinityWord = infinitiveWords[randomNumber];
        String pastSimpleWord = pastSimpleWords[randomNumber];
        String pastParticularWord = pastParticularWords[randomNumber];

        this.englishWords = new EnglishWords(infinityWord, pastSimpleWord, pastParticularWord);
    }

    public String getRussianWord() {
        return russianWord;
    }

    public EnglishWords getEnglishWords() {
        return englishWords;
    }
}
