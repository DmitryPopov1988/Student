package rest.repository;

import rest.model.Subject;
import java.util.List;

public interface SubjectDao {

  List<Subject> getAll();
  Subject getById(long id);
  long createSubject(Subject subject);
  long updateSubject(Subject subject);
  long deleteSubjectById(long id);

}
