include_rules = [
  "+content/public",

  "+crypto",
  "+net",
  "+sandbox",
  "+skia",
  "+ui",
  "+v8",
  "+webkit",

  # Allow inclusion of third-party code.
  "+third_party/skia",
  "+third_party/WebKit/public/platform",
  "+third_party/WebKit/public/web",

  # Files generated during Crosswalk build.
  "+grit/xwalk_resources.h",
]

vars = {
}

deps = {
#    'src/xwalk/third_party/tenta/sqlitecrypt': 'git@bitbucket.org:mikandi/android-database-sqlitecrypt.git@origin/chromium_64',
#    'src/xwalk/third_party/tenta/meta_fs' : 'git@bitbucket.org:mikandi/file-metadata-sqlite.git@origin/chromium_64',
#    'src/xwalk/third_party/tenta/chromium_cache' : 'git@bitbucket.org:mikandi/chromium-cache-metafs.git@origin/chromium_64',
#    'src/xwalk/third_party/tenta/crosswalk_extensions' : 'git@bitbucket.org:mikandi/crosswalk-extensions.git@origin/chromium_64',
#    'src/xwalk/third_party/tenta/mimicvpn' : 'git@bitbucket.org:mikandi/chromium-mimicvpn.git',
}

hooks = [
  #{
  #  # Generate .gclient-xwalk for Crosswalk's dependencies.
  #  "name": "generate-gclient-xwalk",
  #  "pattern": ".",
  #  "action": ["python", "src/xwalk/tools/generate_gclient-xwalk.py"],
  #},
  #{
  #  # Fetch Crosswalk dependencies.
  #  "name": "fetch-deps",
  #  "pattern": ".",
  #  "action": ["python", "src/xwalk/tools/fetch_deps.py", "-v"],
  #},
  {
    'action': [
      'download_from_google_storage',
      '--no_resume',
      '--platform=win32',
      '--no_auth',
      '--bucket',
      'chromium-gn',
      '-s',
      'src/xwalk/buildtools/win/gn.exe.sha1'
    ],
    'pattern':
      '.',
    'name':
      'gn_win'
  },
  {
    'action': [
      'download_from_google_storage',
      '--no_resume',
      '--platform=darwin',
      '--no_auth',
      '--bucket',
      'chromium-gn',
      '-s',
      'src/xwalk/buildtools/mac/gn.sha1'
    ],
    'pattern':
      '.',
    'name':
      'gn_mac'
  },
  {
    'action': [
      'download_from_google_storage',
      '--no_resume',
      '--platform=linux*',
      '--no_auth',
      '--bucket',
      'chromium-gn',
      '-s',
      'src/xwalk/buildtools/linux64/gn.sha1'
    ],
    'pattern':
      '.',
    'name':
      'gn_linux64'
  },
  {
    'action': [
      'download_from_google_storage',
      '--no_resume',
      '--platform=win32',
      '--no_auth',
      '--bucket',
      'chromium-clang-format',
      '-s',
      'src/xwalk/buildtools/win/clang-format.exe.sha1'
    ],
    'pattern':
      '.',
    'name':
      'clang_format_win'
  },
  {
    'action': [
      'download_from_google_storage',
      '--no_resume',
      '--platform=darwin',
      '--no_auth',
      '--bucket',
      'chromium-clang-format',
      '-s',
      'src/xwalk/buildtools/mac/clang-format.sha1'
    ],
    'pattern':
      '.',
    'name':
      'clang_format_mac'
  },
  {
    'action': [
      'download_from_google_storage',
      '--no_resume',
      '--platform=linux*',
      '--no_auth',
      '--bucket',
      'chromium-clang-format',
      '-s',
      'src/xwalk/buildtools/linux64/clang-format.sha1'
    ],
    'pattern':
      '.',
    'name':
      'clang_format_linux'
  },
  {
    # From src/DEPS: fetch the Google Play services library and, if
    # necessary, prompt the user to accept its EULA.
    # Run here because fetch_deps.py (itself a hook) runs another gclient
    # instance and it all causes buffering problems that do not show the EULA
    # prompt when necessary.
    # Note that this hook is run after all Chromium hooks. This is not a
    # problem as of M48, but this needs to be kept in mind in case things start
    # to break.
    'action': [
      'python',
      'src/build/android/play_services/update.py',
      'download'
    ],
    'pattern':
      '.',
    'name':
      'sdkextras'
  },
  {
    # A change to a .gyp, .gypi, or to GYP itself should run the generator.
    "name": "gyp-xwalk",
    "pattern": ".",
    "action": ["python", "src/xwalk/gyp_xwalk"],
  }
]
