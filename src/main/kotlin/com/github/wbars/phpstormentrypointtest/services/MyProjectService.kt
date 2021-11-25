package com.github.wbars.phpstormentrypointtest.services

import com.intellij.openapi.project.Project
import com.github.wbars.phpstormentrypointtest.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
