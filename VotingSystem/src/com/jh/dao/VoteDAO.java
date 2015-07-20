package com.jh.dao;

import java.util.List;

import com.jh.bean.Vote;
import com.jh.util.Page;

/**  
 * �ӿ����ƣ� VoteDAO
 * �ӿ������� ����ͶƱ�����в���
*/ 

public interface VoteDAO {
	public void addVote(Vote vote);										//���ͶƱ
	public void updateVote(Vote vote);									//����ͶƱ
	public void deleteVote(int voteID);									//ɾ��ͶƱ
	public List<Vote> findAllVote(Page page);							//��ҳ��ѯ����ͶƱ
	public List<Vote> findVoteByChannel(Page page,int channelID);		//��ҳ��ѯÿƵ����ͶƱ
	public Vote findVoteById(int voteID);								//ͨ��ID��ѯͶƱ
	public Vote findVoteByName(String voteName);						//ͨ�����Ʋ�ѯͶƱ
	public int findAllCount();											//��ѯ���м�¼��
	public int fintCountByChannel(int channelID);						//��ѯÿƵ���µļ�¼��
}
