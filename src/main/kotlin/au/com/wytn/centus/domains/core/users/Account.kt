package au.com.wytn.centus.domains.core.users

import au.com.wytn.centus.domains.Model
import javax.persistence.*
import java.time.LocalDateTime
import java.util.HashSet

//@Entity
//@Table(name = "userAccounts")
class Account : Model {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @Column(name = "firstname")
    var firstName: String? = null

    @Column(name = "lastname")
    var lastName: String? = null

    @Column(name = "email", nullable = false)
    var email: String? = null

    @Column(name = "password", nullable = false)
    var password: String? = null

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    var status = Status.SUSPENDED


    @Column(name = "lastLoginAt")
    var lastLoginAt: LocalDateTime? = null

    @ManyToMany
    @JoinTable(name = "userAccountsRoles",
            joinColumns = [JoinColumn(name = "userAccountId")],
            inverseJoinColumns = [JoinColumn(name = "userRoleId")])
    var roles: MutableSet<Role> = HashSet()

    @ManyToMany
    @JoinTable(name = "userAccountsPermissions",
            joinColumns = [JoinColumn(name = "userAccountId")],
            inverseJoinColumns = [JoinColumn(name = "userPermissionId")])
    var permissions: Set<Permission> = HashSet()

    @Transient
    fun getRole(): Role? = roles.first()

    @Transient
    fun setRole(role: Role) = roles.add(role)

    @Transient
    fun name(): String = String.format("%s %s", firstName, lastName)

}
