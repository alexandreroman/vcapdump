# Dump `VCAP_SERVICES`

Use this app on Cloud Foundry to dump the content of the environment variable
`VCAP_SERVICES`, as seen by an app.

This variable is exposed in an endpoint as a JSON value:
```shell
$ curl vcapdump.apps.yourdomain.com | jq
{
  "credhub": [
    {
      "binding_name": null,
      "credentials": {
        "uri": "jdbc:mysql://john:secret@area51.gov/mib"
      },
      "instance_name": "really-secret-db",
      "label": "credhub",
      "name": "really-secret-db",
      "plan": "default",
      "provider": null,
      "syslog_drain_url": null,
      "tags": [
        "credhub"
      ],
      "volume_mounts": []
    }
  ],
}
```

## Contribute

Contributions are always welcome!

Feel free to open issues & send PR.

## License

Copyright &copy; 2018 Pivotal Software, Inc.

This project is licensed under the [Apache Software License version 2.0](https://www.apache.org/licenses/LICENSE-2.0).
