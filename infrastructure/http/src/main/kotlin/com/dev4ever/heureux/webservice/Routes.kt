/*
Copyright (©) 2025 Thinh Truong Nguyen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without limitation in the rights to use, copy, modify, merge,
publish, and/ or distribute copies of the Software in an educational or
personal context, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

Permission is granted to sell and/ or distribute copies of the Software in
a commercial context, subject to the following conditions:
Substantial changes: adding, removing, or modifying large parts, shall be
developed in the Software. Reorganizing logic in the software does not warrant
a substantial change.

This project and source code may use libraries or frameworks that are
released under various Open-Source licenses. Use of those libraries and
frameworks are governed by their own individual licenses.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

Created At: 22:46 - 25/03/2025
*/

package com.dev4ever.heureux.webservice

// <editor-fold desc="ESSENTIAL PACKAGES">
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Method.POST
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.CREATED
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes

// </editor-fold>

val htmlPage = """
  <html>
      <body>
          <h1 style="text-align:center; font-size:3.2em; color:orange;" >
          Say hi, from Vietnam!
          </h1>
          <hr>
          <footer>
            <p style="text-align:center; font-size:1.2em; color:grey;">
              <em>Petites habitudes, grandes réussites</em>
            </p>
          </footer>
      </body>
  </html>
""".trimIndent()

val handler: HttpHandler = routes(
  "/" bind GET to ::sayHello,
  "/hello" bind GET to ::sayHello,
  "/message" bind POST to ::helloMessage,
)

//val handler: HttpHandler = {
//  Response(OK).body(htmlPage)
//}

fun helloMessage(req: Request): Response = Response(CREATED)
  .body("Received ${req.bodyString()} from hello message")

fun sayHello(req: Request): Response = Response(OK)
  .body(htmlPage)