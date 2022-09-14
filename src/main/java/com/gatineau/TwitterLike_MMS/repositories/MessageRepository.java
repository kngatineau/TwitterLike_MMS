package com.gatineau.TwitterLike_MMS.repositories;

import com.gatineau.TwitterLike_MMS.beans.Message;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    @Query(value="{ 'github_id' :  '?0'}")
    List<Message> findByGitHubID(String github_id);

    @Query(value="{ 'title' :  '?0'}")
    List<Message> findByTitle(String github_id);



    @Query(value="{ 'date' :  '?0'}")
    List<Message> findAllByDateAsc();

    @Query(value="{ 'date' :  '?0'}")
    List<Message> findAllByDateDesc(String github_id);

    // because UUIDs are randomly generated and not incremental, sorting by date is necessary versus _id
    @Aggregation(pipeline = {
            "{'$match':{'github_id':'?0'}}",
            "{'$sort' : {'date' :  1}}"
    })
    List<Message> findByGitHubIDByDateAsc(String github_id);

    @Aggregation(pipeline = {
            "{'$match':{'github_id':'?0'}}",
            "{'$sort' : {'date' :  -1}}"
    })
    List<Message> findByGitHubIDByDateDesc(String github_id);

    @Aggregation(pipeline = {
            "{'$match':{'github_id':'?0'}}",
            "{'$sort' : {'date' :  -1}}",
            "{'$limit' : 10}"
    })
    List<Message> findByGitHubIDByDateDescLimit10(String github_id);

}