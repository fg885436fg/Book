package test;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bswxb.dao.BookDao;
import com.bswxb.dao.CollectionBookDao;
import com.bswxb.dao.UpdateBooksDao;
import com.bswxb.service.BookService;
import com.bswxb.service.TimeTaskService;
import com.bswxb.util.Out;
import com.bswxb.vo.BookList;



public class test {

	public static void main(String[] args) {
	
		Out  out = new Out(); 
				
		
		
		
		String [] conf = new String[]{
			
				"classpath:applicationContext.xml"
			};
         	AbstractApplicationContext context = new ClassPathXmlApplicationContext(conf);
         	TimeTaskService action = context.getBean(TimeTaskService.class);
         	action.myTest();
         	
 	
 	 
            
            
            
            
            
            
            
            
         	/*BookService  action = context.getBean(BookService.class);
         	Out outTo = new Out();
         	List<Book_Book> books= action.findAll();
         	
         	for (Book_Book book : books) {
	
         			outTo.outText(book.getBook_Adress(),"bookList");
         			
         		}
         	
         	*/
         	
         	
         	
         	
         	/*for (Book_Book book : books) {
         		
         		if(book.getBook_site().equals("起点")) {
         			
         			outTo.outText(book.getBook_Adress(), book.getBook_site());
         			
         		}
         		
         		if(book.getBook_site().equals("SF")) {
         			
         			outTo.outText(book.getBook_Adress(), book.getBook_site());
         			
         		}
         		
         		if(book.getBook_site().equals("轻文")) {
         			
         			outTo.outText(book.getBook_Adress(), book.getBook_site());
         			
         		}
         		
         		if(book.getBook_site().equals("书客")) {
         			
         			outTo.outText(book.getBook_Adress(), book.getBook_site());
         			
         		}
         		
         		
				
			}*/
         	
         	
         	
         	/*score.setBook(actionBook.findOne(7));
         	score.setUser(actionUser.findOne(12));
         	score.setAssess(5);
         	action.save(score);*/
         	
         	
         	
         	
         	
   
         	/* 	BookDao   action = context.getBean(BookDao.class);
         	List<Book_Book> booklist = action.findAll();
            for (Book_Book book : booklist) {
            	
            	out.outText(book.getBook_Adress());
            	}
*/
            
            
            
            
            
            
            
            
         	
         	
//         	24
         	//http://book.sfacg.com/Novel/72520/,http://www.hbooker.com/book/100031461,http://book.sfacg.com/Novel/6492
//         	action.addUserBooks("http://book.sfacg.com/Novel/72520/",24);
         
//         for (Book_Book book : books) {
//			
//        	 System.out.println(book.getBook_Name());
//		}
         	
        	
//		List<Book_Book> books = new ArrayList<Book_Book>();
//		Book_Book book = new Book_Book();

//		action.findByWord("='百合'","book_Words", "is not null", "10w", "全部", 1);
		
//		action.search("变身", 1);
//		
//		for (Book_Book book : books) {
//			
//			System.out.println(book.getBook_Name());
//			
//		}


		
/*		BookDao dao = context.getBean(BookDao.class);
		dao.search("我的画风不对怎么想都是次元的错");
		dao.search("我的画风不对怎么想都是次元的错");
		*/
		
		
		

	}

}
