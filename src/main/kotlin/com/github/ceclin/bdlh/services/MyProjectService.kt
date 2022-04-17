package com.github.ceclin.bdlh.services

import com.intellij.openapi.project.Project
import com.github.ceclin.bdlh.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
