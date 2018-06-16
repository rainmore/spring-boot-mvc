package au.com.wytn.centus.controllers.core.users

import au.com.wytn.centus.domains.core.users.Role
import au.com.wytn.centus.modules.core.users.UserRoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController
import org.yaml.snakeyaml.constructor.BaseConstructor
import java.util.*

@RestController
class UserRoleRestController @Autowired constructor(private val repository: UserRoleRepository) : BaseConstructor() {
    companion object {
        private const val URL_LIST       = "/api/users/roles"
        private const val URL_ADD        = "/api/users/roles/add"
        private const val URL_ITEM       = "/api/users/roles/{id}"
        private const val URL_ACTIVATE   = "/api/users/roles/{id}/activate"
        private const val URL_DEACTIVATE = "/api/users/roles/{id}/deactivate"
    }

    @GetMapping(URL_LIST)
    fun list(pageable: Pageable): Page<Role> {
        return repository.findAll(pageable)
    }

    @GetMapping(URL_ITEM)
    fun item(@PathVariable id: Int): Optional<Role> {
        return repository.findById(id)
    }

    @PutMapping(URL_ACTIVATE)
    fun activate(@PathVariable id: Int): Optional<Role> {
        val item = repository.findById(id)
        return item
    }

    @PutMapping(URL_DEACTIVATE)
    fun deactivate(@PathVariable id: Int): Optional<Role> {
        val item = repository.findById(id)
        return item
    }
}