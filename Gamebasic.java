package baseballgame;

public class Gamebasic {
//ここからループさせる
	static boolean pitchstrike;
	static boolean swing;
	static boolean contact ;//メインの中に入れてもいいかも
	static boolean fair ;
	static int contactresult ;
	static int strike ;
	static int ball ;
	static int out ;
	static boolean firstrunner ;
	static boolean secondrunner ;
	static boolean thirdrunner ;
	static int score ;
	static boolean fourball;
	static int inning;
	static int allscore;
	static int allsingle ;
	static int allsecond;
	static int allthird;
	static int allhomerun;
	static int allstrikeout;
	static int allfourball;
	static boolean strikeout;


       public static void main(String[] args){
    	   allscore = 0;//allscoreの初期化
    	   int i;
    	   for (i = 0; i <144; i++) {





    	   
    	   inning = 0;



    	   while(inning <=8){
    	   inning += 1;



    	   score = 0;//scoreの初期化
    	   out = 0;

    	   while(out < 3){//３アウトまで繰り返す

    	   //pitchstrike
    	   int a ;
    	   a = (int)(Math.random()*100+1);//投げた球がストライクか

    	   pitchstrike = (a>= 45);//aが40以上でストライク
    	   if(pitchstrike == true){
    //  System.out.println("strike");
    	   }
    	   else{
    //  System.out.println("ball");
    	   }


    	   //swing
    	   int b ;
    	   b = (int)(Math.random()*100+1);

    	   swing = ((pitchstrike == true) && (b >= 35))||((pitchstrike == false) && (b >= 80));//sならb35以上bならb80以上でスイング
    	   if(swing == true){
    	// System.out.println("swing");//swing
	       }else if(pitchstrike == true){
	 // 	   System.out.println("watchstrike");//notswing
	       }else{

	  //   System.out.println("ball");
	       }



    	   //contuct
    	   if(swing == true){
    	   int c ;                                   //batcontuct
    	   c = (int)(Math.random()*100+1);

    	   contact = (((pitchstrike == true) &&(c >= 15))|| ((pitchstrike == false) && (c >= 40)) );//sならc20以上、bならｃ５０以上で当たる
    	   if(contact == true){
    	// System.out.println("contact");
    	   }else{
    //System.out.println("whiff");
    	   }
    	   }


    	   //fair or farr
    	   if(contact == true){    // fair
    	   int d ;
    	   d = (int)(Math.random()*100+1);

    	   fair = (d >= 75);      //7割fair
    	   if(fair == true){
    //  System.out.println("fair");
    	   }else{
    	//  System.out.println("farr");

    	   }
    	   }


    	   //contuctresult
    	   if(fair ==true){
    		   int e ;
    		   e = (int)(Math.random()*100+1);
    		   if(e >= 98){
    			   contactresult = 4;
    			   score += 1;
    		//  System.out.println("ホームラン");
    		   }else if(e >= 97){
    			   contactresult = 3;

    	//   System.out.println("三塁打");
    		   }else if(e >= 93){
    			   contactresult = 2;

    	//   System.out.println("二塁打");
    		   }else if(e >= 69){
    			   contactresult = 1;

    	//   System.out.println("ヒット");
    		   }else {
    			   contactresult = 0;
    			   out += 1;
    	//   System.out.println("アウト");
    		   }
    		// System.out.println(contactresult);//この下にかうんと＝0入れる

    		   strike = 0;
    		   ball = 0;





    		   }
    	   //count
    	   //strike　　　　ストライクの加算と三振のチェック
    	   if(((pitchstrike == true) && ((swing == false) || (contact == false))) ||((pitchstrike == false) &&((swing == true) && (contact == false)))){//ストライク見逃し、ボール空振り
    		   strike += 1;
    		   if(strike == 3){
    			   out += 1;
    			   strike = 0;
    			   ball = 0;
    			   strikeout = true;
    		//  System.out.println("strikeout");
    		   }
    		   if((swing == true) && (fair == false)){
    			   if(strike <= 1){
    				   strike += 1;
    			   }
    		   }
    	   }

    	   //ball
    	   if((pitchstrike == false) && (swing == false)){//  フォアボールのチェックとボーるの加算
    		   ball += 1;
    		   if(ball == 4){
    			   strike = 0;
    			   ball = 0;
    			   fourball = true;                              //フォアボールの扱い！
    		//	   System.out.println("fourball");


    		   }
    	   }

    	   //out
    	  //ystem.out.println("outcount"+out);//アウトカウントの表示   ３アウトかのチェック
    	   if(out == 3){
    		   firstrunner = false;
    		   secondrunner = false;
    		   thirdrunner = false;
    		//   System.out.println("change");

    		   //この下にチェンジの処理入れる！

    	//	   System.out.println(score);




    	   }





    	    //runner
    	   //thirdrunner
    	   if(thirdrunner == true){
    		   if(contactresult >= 1){
    			   score += 1;
    			   if(contactresult == 3){
    				   thirdrunner = true;
    			   }else{
    				   thirdrunner = false;
    			   }
    		   }
    	   }

    	   //secondrunner

    	   if(secondrunner == true){
    		   if(contactresult >= 2){
    			   score += 1;
    			   if(contactresult == 2){
    				   secondrunner = true;
    			   }else{
    				   secondrunner = false;
    			   }
    		   }else if(contactresult == 1){//二塁から単打で６割生還
    			   int g;
        		   g = (int)(Math.random()*100+1);
        		   if(g >= 40){
        			   score += 1;

        		   }else{
        			   thirdrunner = true;
        		   }
        		   secondrunner = false;

    		   }
    	   }

    	   //firstrunner
    	   if(firstrunner == true){
    		   if(contactresult >= 3){
    			   score += 1;
    			   firstrunner = false;

    		   }else if(contactresult == 2){//1走者は二塁打で４割生還
    			   int g;
        		   g = (int)(Math.random()*100+1);
        		   if(g >= 60){
        			   score += 1;
        			   firstrunner = false;

        		   }else{
        			   firstrunner = false;
        			   thirdrunner = true;
        		   }
    		   }else if(contactresult == 1){//１塁走者の三塁進塁率25パー(単打）
    			   int g;
        		   g = (int)(Math.random()*100+1);
        		   if((g >= 75) && (thirdrunner == false)){//三塁で止まっているランナーがいない
        			   thirdrunner = true;
        			   firstrunner = true;
        		   }else{
        			   secondrunner = true;
        			   firstrunner = true;
        		   }
    		   }

    	   }//firstrunner終わり

    	   if(contactresult == 3){
    		   thirdrunner = true;
    	   }
    	   if(contactresult == 2){
    		   secondrunner= true;
    	   }
    	   if(contactresult == 1){
    		   firstrunner = true;
    	   }

    	   //fourball
    	   if(fourball == true){
    		   if(firstrunner == true){
    		   if((firstrunner == true) && (secondrunner == true) && (thirdrunner == true)){
    			   score += 1;
    		   }else if(secondrunner == true){
    			   thirdrunner = true;
    		   }else{
    			   secondrunner = true;
    		   }
    		   }else {
    			firstrunner = true;
    		   }

    	   }

    	   if(contactresult == 1){
    		   allsingle += 1;
    	   }
    	   if(contactresult == 2){
    		   allsecond += 1;
    	   }
    	   if(contactresult == 3){
    		   allthird += 1;
    	   }
    	   if(contactresult == 4){
    		   allhomerun+= 1;
    	   }
    	   if(fourball == true){
    		   allfourball += 1;
    	   }
    	   if(strikeout == true){
    		   allstrikeout += 1;
    	   }









    	   //初期化
    	   fourball = false;
    	   strikeout = false;


    	   contactresult = 0;





















       }//whileの終わり（３アウト）
    //	   System.out.println( inning+"ininngs is"+score);
    	   allscore = allscore + score;


    	   }//whileの終わり９イニング






    	 }//144試合の終わり

    	   System.out.println("game finished all score is"+allscore);
    	   System.out.println("single is"+allsingle);
    	   System.out.println("second is"+allsecond);
    	   System.out.println("third is"+allthird);
    	   System.out.println("homerunis"+allhomerun);
    	   System.out.println("strikeout"+allstrikeout);
    	   System.out.println("fourbaall"+allfourball);
    	   float dasuu;
    	   dasuu = 0;
    	   dasuu = 144*27+allsingle+allsecond+allthird+allhomerun;

    	   float anda;
    	   anda = allsingle+allsecond+allthird+allhomerun;
    	   float daritu;
    	   daritu = 0;
    	   daritu =anda/dasuu;
    	   System.out.println("daritu"+daritu);
    	   System.out.println("dasuuu"+dasuu);

    	   System.out.println("andaaa"+anda);








       }//mainの終わり
       
       //投手能力
       
       
}//packageの終わり
