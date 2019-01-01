package H_Proeject.Mangement.domain;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPaMain {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook"); // EntityFactory 생성
		EntityManager em= emf.createEntityManager(); // EntityManager 생성
		EntityTransaction tx = em.getTransaction();	// Transaction 생성
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		}catch(Exception e) {
			tx.rollback(); // 롤백
		}finally{
			em.close();
		}
		emf.close();
	}
	private static void logic(EntityManager em) {
		
		String id="jaehunya";
		Member member = new Member();
	
			//member.setAge(30);
			//member.setId(id);
			//member.setUsername("재훈");
			//등록(persits)
			//em.persist(member);
			//전체 목록조회
			//List<Member> allMember = em.createQuery("select m from Member m" , Member.class).getResultList();
			//System.out.println("member.size  = " + allMember.size());
			//한건 조회
			//Member findMember = em.find(Member.class, id);
			//System.out.println("findMember = " + findMember.getUsername() + ", age=" + findMember.getAge());	
			//수정
			//member.setAge(20);
			//member.setUsername("영서바보");
			//삭제 
			Member member1 = em.find(Member.class, "jaehun");
			em.remove(member1);
	}
}
