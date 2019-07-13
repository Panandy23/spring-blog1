package pl.sda.mysimpleblog.repository;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.mysimpleblog.model.Post;
import pl.sda.mysimpleblog.model.enums.CategoryEnum;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Post,Long> {

List<Post> findAllByCategory(CategoryEnum category);
}
