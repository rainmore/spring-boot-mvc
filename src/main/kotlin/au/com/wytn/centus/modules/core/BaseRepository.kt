package au.com.wytn.centus.modules.core

import au.com.wytn.centus.domains.Model
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

@NoRepositoryBean
interface BaseRepository<T: Model, ID: Serializable> :  JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
}