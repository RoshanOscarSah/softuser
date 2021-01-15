package com.assignment.esoftwarica.model

class User {

    fun LoginOperation(username: String, password: String): Boolean {
        return username.trim().toLowerCase().equals("softwarica") && password.trim().toLowerCase()
            .equals("coventry");
    }

}