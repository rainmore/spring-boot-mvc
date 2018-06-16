package au.com.wytn.centus.domains.core.users

enum class Status {
    ACTIVE,
    DISABLED,
    SUSPENDED;

    val isActive: Boolean
        get() = ACTIVE == this

    val isDisabled: Boolean
        get() = DISABLED == this

    val isSuspended: Boolean
        get() = SUSPENDED == this
}
