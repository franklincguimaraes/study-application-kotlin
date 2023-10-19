package io.blufr.studyapplication.utils.enums

enum class UserRoleEnum {
    ADMIN("ADMIN", 1),
    USER("USER", 2),
    GUEST("GUEST", 3);

    private var typeUser: String
    private var id: Int

    constructor(name: String, id: Int) {
        this.typeUser = name
        this.id = id
    }

    fun getName(): String {
        return typeUser
    }

    fun getId(): Int {
        return id
    }
}