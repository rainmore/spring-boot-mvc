package au.com.wytn.centus.domains.core.users

import au.com.wytn.centus.domains.Model
import javax.persistence.*

//@Entity(name = "userPermissions")
//@Table(name = "userPermissions")
class Permission : Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @Column(nullable = false)
    var name: String? = null

    @ManyToOne
    @JoinColumn(name = "parentId")
    var parent: Permission? = null

    constructor() {}

    constructor(name: String) {
        this.name = name
    }
}
