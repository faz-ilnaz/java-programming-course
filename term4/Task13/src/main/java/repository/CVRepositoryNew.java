package repository;

import model.CV;
import model.User;

import java.util.List;

public interface CVRepositoryNew {
    public List<CV> findCVsByOwner(User owner);
}
