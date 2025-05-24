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

Created At: 21:53 - 24/05/2025
*/

package com.dev4ever.heureux.webservice

// <editor-fold desc="ESSENTIAL PACKAGES">
import org.http4k.client.JettyClient
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Status
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.junit.jupiter.api.fail
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

// </editor-fold>
// <editor-fold desc="CLASSES">
internal class SeeAPostsListAcceptanceTest {
    @Test
    fun `Posts owners can see their posts`() {
        val user = "devopsthinh"
        val listName = "Featured-Posts".lowercase()
        val mobileAppTrending = listOf(
            "Kotlin Multiplatform",
            "Kotlin Mobile Multiplatform",
            "Mobile Clean Architecture",
        )

        startTheWebApp(user, listName, mobileAppTrending)

        val posts = getPostsList(user, listName)

        expectThat(posts.listName.name).isEqualTo(listName)
        expectThat(posts.items.map {
            it.title
        }).isEqualTo(mobileAppTrending)
    }

    private fun getPostsList(user: String, listName: String): Posts {
        val client = JettyClient()
        val request = Request(
            GET,
            "http://localhost:8088/posts/$user/$listName"
        )
        val response = client(request)

        return if (response.status == Status.OK)
            parseResponse(response.bodyString())
        else
            fail(response.toMessage())
    }

    private fun parseResponse(html: String): Posts = TODO("parse the response")

    private fun startTheWebApp(
        user: String,
        listName: String,
        items: List<String>,
    ) {
        // Setup user and list

        val posts = Posts(
            ListName(listName),
            items.map(::Article)
        )

        val lists = mapOf(User(user) to listOf(posts))

        val server = Huereux().asServer(Jetty(8088))
        server.start()
    }
}
// </editor-fold>