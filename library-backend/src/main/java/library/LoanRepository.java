package library;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LoanRepository extends CrudRepository<Loan, Integer> {

  @Query("from Loan l inner join Book b on l.bookOnLoan = b.id where b.isbn=:isbn and l.user=:userId and l.returned = false order by l.dueDate")
  List<Loan> findActiveLoansBy(@Param("isbn")long isbn, @Param("userId")String userId);

}
