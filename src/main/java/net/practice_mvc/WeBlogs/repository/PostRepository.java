package net.practice_mvc.WeBlogs.repository;

import net.practice_mvc.WeBlogs.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUrl(String url);

    @Query("SELECT p FROM Post p " +
            "WHERE p.title LIKE CONCAT('%', :query, '%') " +
            "OR p.shortDescription LIKE CONCAT('%', :query, '%')")
    Optional<List<Post>> searchPosts(String query);
}
