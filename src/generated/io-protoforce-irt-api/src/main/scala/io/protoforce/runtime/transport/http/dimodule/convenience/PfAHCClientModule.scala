package io.protoforce.runtime.transport.http.dimodule.convenience

import distage.ModuleDef
import org.asynchttpclient.AsyncHttpClient
import org.asynchttpclient.Dsl.asyncHttpClient

class PfAHCClientModule extends ModuleDef {
  make[AsyncHttpClient].fromValue(asyncHttpClient())
}