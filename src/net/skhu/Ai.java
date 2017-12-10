package net.skhu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ai {
   private Ai ai;
   private List<Integer> cardList;
   private List<Integer> usercardList;
   private int coin;
   
   public Ai(){
      cardList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
      usercardList = new ArrayList<>();
      coin = 30;
      Collections.shuffle(cardList);
   }
   public void aiRechargeDeck() {
      this.cardList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
      Collections.shuffle(this.cardList);
   }
   public List<Integer> getCard(){
      return cardList;
   }
   public void setUserCard(int usercard){
      usercardList.add(usercard);
   }
   public int getUserCard(Game game){
	   
      return usercardList.get(game.getRound()-1);
   }
   public int number(Game game){
	   if(Game.round<=10)
			return cardList.get(game.getRound()-1);
		else
			return cardList.get(game.getRound()-11);
   }
   public int getAiCoin() {
      return coin;
   }
   public void setCoin(int coin) {
      this.coin=coin;
   }
   public int aiBetCoin(int coin)
   {
      return this.coin -=coin;
   }
   //내카드를 보고 있는 ai가 내카드가 크다면 배팅 갯수적게하고 내카드가 작다면 배팅 갯수 높임(배팅할 확률)
   public int aiBattingBattle(int userCard,int userBet)
   {
      int bet =0;
      int rebet =0; //ai가 0을걸때 다시 걸게 할 확률
      if(userCard == 1) //내카드가 1이라면 AI는 배팅(카드 수가 1이니까 다이가 없음)
      {
         bet = (int)(Math.random()*(userBet+2))+userBet;
         if(bet ==0) //ai가 배팅을 0을건다면 0을 못걸게 해야되니까
         {
            rebet =(int)(Math.random()*(userBet+2))+userBet+1;
            return rebet;
         }
         else
            return bet;
      }
      else if(userCard>=2 && userCard<=5) 
      {
         bet = (int)(Math.random()*(userBet+1))+userBet;
         if(bet == 0)//ai가 배팅을 0을건다면 0을 못걸게 해야되니까
         {
            rebet = (int)(Math.random()*(userBet+1))+userBet+1;
            return rebet;
         }
         else   
            return bet;
      }
      else if(userCard<=6 && userCard<=8)
      {
         bet = (int)(Math.random()*(userBet))+userBet;   
         if(bet == 0)//ai가 배팅을 0을건다면 0을 못걸게 해야되니까
         {
            rebet = (int)(Math.random()*(userBet))+userBet+1;
            return rebet;
         }
         else
            return bet;
      }
      else
      {
         bet = (int)(Math.random()*(userBet))+userBet;
         if(bet == 0) //ai가 배팅을 0을건다면 0을 못걸게 해야되니까
         {
            rebet = (int)(Math.random()*(userBet))+userBet+1;
            return rebet;
         }
         else
            return bet;
      }
   }
   
   //ai다이확률
   public int aiDiePercentage(int userCard)
   {
      int die =0;
      if(userCard ==1) //내카드가 1이면 무조건 걸게하기
         return 0;
      else if(userCard>=2 && userCard<=5) 
      {
         die = (int)(Math.random()*1)+1;
         return die; //확률 내보내기
      }
      else if(userCard<=6 && userCard<=8)
      {
         die = (int)(Math.random()*1)+1;   
         return die;
      }
      else
      {
         die = (int)(Math.random()*3)+1;      
         return die;
      }
         
   }
}