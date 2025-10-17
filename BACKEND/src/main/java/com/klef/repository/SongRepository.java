
package com.klef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.klef.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> 
{
   /* Student findByEmail(String email);
    Student findByContact(String contact);*/
}
