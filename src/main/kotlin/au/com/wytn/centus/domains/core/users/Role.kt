package au.com.wytn.centus.domains.core.users

import au.com.wytn.centus.domains.Model
import javax.persistence.*

@Entity
@Table(name = "userRoles")
class Role : Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @Column(nullable = false)
    var name: String? = null

    @ManyToOne
    @JoinColumn(name = "parentId")
    var parent: Role? = null

    @Column(nullable = false)
    var isAlmighty: Boolean? = null

    @Column(nullable = false)
    var isArchived: Boolean? = null

    constructor() {}

    constructor(name: String) {
        this.name = name
    }
}