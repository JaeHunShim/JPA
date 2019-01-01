package H_Proeject.Mangement.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExamMergeMain {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
	
	
	public static void main(String[] args) {
		
		
		Member member = createMember("memberA","회원 1"); //영속성 컨테이너  -> 영속성 컨테이너 종료
		member.setUsername("회원명 변경"); // 영속성 - > 준영속성으로 변경됨
		
		mergeMember(member); // 준영속성 상태 -> 영속성 상태로 변경하기 위해서 merge를 사용해서 다시 영속성 상태로 변경 
	}
	static Member createMember(String id , String username) {
		EntityManager em1 = emf.createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();
		tx1.begin();
		
		Member member = new Member();
		member.setId(id);
		member.setUsername(username);
		member.setAge(30);
		
		em1.persist(member);
		tx1.commit();
		
		em1.close();
		
		return member;
	}
	static void mergeMember(Member member) {
		
		EntityManager em2 = emf.createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();
		
		tx2.begin();
		
		Member mergeMember = em2.merge(member);
		
		tx2.commit();
		
		System.out.println("준영속상태  member = " + member.getUsername());
		System.out.println("em2 contains member = " + em2.contains(member));
		System.out.println("영속상태 member = " + mergeMember.getUsername());
		System.out.println("em2 contains mergeMember = " + em2.contains(mergeMember));
		em2.close();
	}
}
