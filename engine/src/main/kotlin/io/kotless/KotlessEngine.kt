package io.kotless

import io.kotless.gen.Generator
import io.kotless.opt.Optimizer
import io.kotless.terraform.TFFile
import java.io.File

object KotlessEngine {
    fun generate(schema: Schema): Set<TFFile> {
        val optimized = Optimizer.optimize(schema)
        return Generator.generate(optimized)
    }

    fun dump(genDirectory: File, files: Set<TFFile>) = files.map { file -> file.writeToDirectory(genDirectory) }
}
