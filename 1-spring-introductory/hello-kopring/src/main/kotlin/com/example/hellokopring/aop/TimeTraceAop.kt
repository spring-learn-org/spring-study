package com.example.hellokopring.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.*

@Component
@Aspect
class TimeTraceAop {
    @Around("execution(* com.example.hellokopring..*(..))")
    @Throws(Throwable::class)
    fun execute(joinPoint: ProceedingJoinPoint): Any? {
        val start: Long = System.currentTimeMillis()
        println("Start: $joinPoint")

        try {
            return joinPoint.proceed()
        } finally {
            val finish: Long = System.currentTimeMillis()
            val timeMs: Long = finish - start
            println("End: $joinPoint $timeMs ms")
        }
    }
}

// @Component
// @Aspect
// class TimeTraceAop {
//    @Around("execution(* hello.hi.hellospring..*(..))")
//    @Throws(Throwable::class)
//    fun execute(joinPoint: ProceedingJoinPoint): Any {
//        val start = System.currentTimeMillis()
//        println("START: $joinPoint")
//        return try {
//            joinPoint.proceed()
//        } finally {
//            val finish = System.currentTimeMillis()
//            val timeMs = finish - start
//            println("END: " + joinPoint.toString() + " " + timeMs + "ms")
//        }
//    }
// }
