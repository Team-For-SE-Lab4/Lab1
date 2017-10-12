package lab1;
import java.util.*;

public class graph {
	private Vector<word> wordList;//ͼ�Ļ�������(����ӵ�git������ע�ͣ�
	
	public graph(){
		wordList=new Vector<word>();    //B1 branch:the first update
	}		
	
	public Vector<word> getWordList(){//����ͼ�����нڵ�ļ���
		return wordList;
	}
	
	public int getWordIndex(String wd){//���ص�����wordList�е�λ��
		int i,rt=-1;
		String x;
		for (i=0;i<wordList.size();i++){
			x=wordList.get(i).getname();
			if (x.equalsIgnoreCase(wd))
			{
				rt=i;
				break;
			}
		}
		return rt;
	}
	
	public void createGraph(String firstWord, String secondWord){
		int sign=0;
		int i;			
		for( i=0;i<wordList.size();i++){
			if(wordList.elementAt(i).getname().equals(firstWord)){		//�жϴ˵����Ƿ���ֹ�
				sign=1;
				break;
			}
				}
			if(sign==1){                                  
				wordList.elementAt(i).searchLink(secondWord);}            //�ж�ͼ�ı��Ƿ���ֹ�
			else {  //�µ���
				word newWord= new word(firstWord);
				wordList.addElement(newWord);
				newWord.addLinkList(secondWord);	
			}	
	}
	
	public void createGraph(String lastWord){
		int sign=0;
		int i;			
		for( i=0;i<wordList.size();i++){
			if(wordList.elementAt(i).getname().equals(lastWord)){		//�жϴ˵����Ƿ���ֹ�
				sign=1;
				break;
			}
				}
			if(sign==1);           //�ж�ͼ�ı��Ƿ���ֹ�
			else {  //�µ���
				word newWorld= new word(lastWord);
				wordList.addElement(newWorld);	
			}	
	}
	
	
	/*public void showGraph(){
		for(int counter=0;counter< wordList.size();counter++){
			wordList.elementAt(counter).show();
		}
	}*/
	
	public String getCommand(){ //����graphzip���
		String s=new String();
		s = "digraph abc{";
		for(int i=0;i<wordList.size();i++){
			s+=wordList.elementAt(i).getname()+";\n";
		}
		for(int i=0;i<wordList.size();i++){
			s+=wordList.elementAt(i).graphInf();
		}	
		s+="}";
		return s;
	}
	
	public int getWordNum(){
		return wordList.size();
	}
	
	public int[][] getMatrix(){//��������ͼ���ڽӾ���
		final int maxNum=100000;
		int i,j;
		int sign;
		int graphMatrix[][]=new int[wordList.size()][wordList.size()];
		for (i=0;i<wordList.size();i++)
		{
			for (j=0;j<wordList.size();j++)
			{
				sign=wordList.get(i).judgeOfWord(wordList.get(j).getname());
				if (sign==-1)
				{
					graphMatrix[i][j]=maxNum;
				}
				else
				{
					graphMatrix[i][j]=wordList.get(i).getWeight(sign);
				}
			}
		}
		return graphMatrix;
	}
	
	
	
	public void changeEdgeColor(int orderedNum, int edgeNum, int colorNum){
		word changedWord= wordList.get(orderedNum);    //ȷ��������ɫ�ĵ���
		int edgeIndex=changedWord.indexOfEdge(wordList.get(edgeNum).getname());
		changedWord.changecolor(edgeIndex, colorNum);
	}
	
	public void colorClean(){
		for(int i=0;i<wordList.size();i++)
			wordList.get(i).colorCleaned();
	}

	
	public String indexofVector(int num){
		return wordList.elementAt(num).getname();
	}
	
	//��ѯ�ŽӴ�
	public boolean queryExist(String wd){//��ѯһ�������Ƿ����������ͼ��
		int i;
		for (i=0;i<wordList.size();i++)
		{
			if (wordList.get(i).getname().equalsIgnoreCase(wd))
			{
				return true;
			}
		}
		return false;
	}
	public word findWord(String wd){//����һ���������ڵĽڵ�word����
		int i;
		word temp=new word();
		for(i=0;i<this.wordList.size();i++){
			temp=this.wordList.get(i);
			if(temp.getname().equalsIgnoreCase(wd))
				break;
		}
		return temp;
	}
	
	
	
}
