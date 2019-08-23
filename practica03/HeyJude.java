public class HeyJude{
    
    public static String HEY = "Hey Jude ";
    public static String DON = "don't ";
    public static String MAK = "make it bad.";
    public static String BEA = "be afraid.";
    public static String LET = "let me down.";
    public static String TAK = "Take a sad song and make it better.";
    public static String YOW = "You were made to go out and get her.";
    public static String YOH = "You have found her, now go and get her.";
    public static String REM = "Remember to ";
    public static String LEH = "let her into you heart.";
    public static String LES = "let her into your skin.";
    public static String THE = "Then you ";
    public static String CAN = "can start ";
    public static String BEG = "begin ";
    public static String TOM = "to make it better ";
    public static String BET = "better ";
    public static String NA  = "na ";

    public static String AND = "And anytime you feel the pain, hey Jude, refrain,\n"
	                     + "Don’t carry the world upon your shoulders.\n"
                     	     + "For well you know that it’s a fool who plays it cool\n"
	                     + "By making his world a little colder.";

    public static String SOL = "So let it out and let it in, hey Jude, begin,\n"
	                            + "You’re waiting for someone to perform with.\n"
	                            + "And don’t you know that it’s just you, hey jude, you’ll do,\n"
	                            + "The movement you need is on your shoulder.";

    //agregado
    public static String THM = "The minute you let her under your skin";
    //agregado 
    
    public static void main(String[] args){

	int c = 0;
	int a = 0;
	
	while(c < 4) {
	System.out.print(HEY+DON);

	if (c==0 || c==3){
	    System.out.println(MAK);
	    System.out.println(TAK);
	    
	} else if (c==1){
	    System.out.println(BEA);
	    System.out.println(YOW);
	    
	} else if (c==2){
	    System.out.println(LET);
	    System.out.println(YOH);
	}

	switch(c){
	case 0:
	    System.out.println(REM+LEH);
	    break;
	case 1:
	    System.out.println(THM);
	    break;
	case 2:
	    System.out.println(REM+LEH);
	    break;
	case 3:
	    System.out.println(REM+LES);
	}

	System.out.print(THE);

       	for(int r=0; r<2; r++){
	    if (c==0 || c==2) {
	    System.out.print(CAN);
	    
	    } else {
		System.out.print(BEG);
	    }
	}
	System.out.println(TOM);
	System.out.println();
	
	if (c==1){
	    System.out.println(AND);

	    while(a<5){
		System.out.print(NA);
		a++;
	    }
	    
	    System.out.println();
	    System.out.println();
	    
	}

	if (c==2){
	    System.out.println(SOL);

	    while(a<10){
		System.out.print(NA);
		a++;
	    }
	    System.out.println();
	    System.out.println();
	}

	c++;
	}

	for(int t=0; t<10; t++){
	    System.out.print(NA);
	}

	System.out.println();
    }
}
