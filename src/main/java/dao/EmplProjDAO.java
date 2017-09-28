package dao;

import entity.EmplProj;

import java.util.List;

public interface EmplProjDAO {
    // create
    void add(EmplProj emplProj);

    // read
    List<EmplProj> getAll();

    EmplProj getByEmpliyeeIdAndProjectId(Long employeeId, Long projectId);

    // update
    void update(EmplProj emplProj);

    // delete
    void remove(EmplProj emplProj);
}
