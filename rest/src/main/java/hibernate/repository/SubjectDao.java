package hibernate.repository;

import hibernate.model.Subject;
import java.util.List;

public interface SubjectDao {

  List<Subject> getAll();
  Subject getById(long id);
  long createSubject(Subject subject);
  long updateSubject(Subject subject);
  long deleteSubjectById(long id);

}
