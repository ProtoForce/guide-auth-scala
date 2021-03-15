package io.protoforce.guide.auth



object ClientConfigs {
  /**
    * Defined at config.pfm @ 67:5
    */
  final lazy val local: ClientConfig = ClientConfig(
    github = GithubClientConfig(
      clientId = ""
    ),
    google = GoogleClientConfig(
      clientId = "",
      redirectUrl = ""
    ),
    facebook = FacebookConfig(
      appId = ""
    ),
    endpoint = "http://localhost:8081/api",
    twitter = TwitterClientConfig(
      customerId = ""
    )
  )
}