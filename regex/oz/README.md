# oz's regex

    Revision 1.4 (1991/10/17)

A public domain regular expression pattern matching and replacement implementation in C, by [Ozan S. Yigit]  (aka "oz"), Dept. of Computer Science, York University (Canada).

Also used by [Scintilla], the famous free source code editing component (see [`RESearch.cxx`][RESearch.cxx]).

Downloaded from:

- http://www.cse.yorku.ca/~oz/regex.bun

-----

**Table of Contents**

<!-- MarkdownTOC autolink="true" bracket="round" autoanchor="false" lowercase="only_ascii" uri_encoding="true" levels="1,2,3" -->

- [Folder Contents](#folder-contents)
- [License and Credits](#license-and-credits)

<!-- /MarkdownTOC -->

-----

# Folder Contents

> **NOTE** — All files were extracted from the single [`regex.bun`][regex.bun] bundled file (not included here) available at oz's website.

C sources:

- [`regex.c`][regex.c]/[`regex.h`][regex.h] — Regular expression pattern matching and replacement.
- [`re_fail.c`][re_fail.c] — Default internal error handler for `re_exec()`.
- [`grep.c`][grep.c] — Rudimentary grep to test regex routines.

Other:

- [`makefile`][makefile]
- [`regex.3`][regex.3] — Documentation.

None of the original files where altered, except for code style conventions adaptations (tabs to spaces, trimmed trailing spaces, etc.).


# License and Credits

Public domain.

From [`grep.c`][grep.c] opening comments:

```c
/*
 * regex - Regular expression pattern matching  and replacement
 *
 * By:  Ozan S. Yigit (oz)
 *      Dept. of Computer Science
 *      York University
 *
 * These routines are the PUBLIC DOMAIN equivalents of regex
 * routines as found in 4.nBSD UN*X, with minor extensions.
 *
 * These routines are derived from various implementations found
 * in software tools books, and Conroy's grep. They are NOT derived
 * from licensed/restricted software.
```

<!-----------------------------------------------------------------------------
                               REFERENCE LINKS
------------------------------------------------------------------------------>

[regex.bun]: http://www.cse.yorku.ca/~oz/regex.bun "view original source file"

<!-- project files -->

[grep.c]: ./grep.c "View source file"
[makefile]: ./makefile "View source file"
[re_fail.c]: ./re_fail.c "View source file"
[regex.3]: ./regex.3 "View source file"
[regex.c]: ./regex.c "View source file"
[regex.h]: ./regex.h "View source file"

<!-- Scintilla -->

[Scintilla]: https://www.scintilla.org "Visit Scintilla website"

[RESearch.cxx]: https://github.com/mirror/scintilla/blob/a6d738543a0efd2d2ee3e985ab26c83eecbbd1a0/src/RESearch.cxx#L6 "View 'RESearch.cxx' source code on GitHub"

<!-- people -->

[Ozan S. Yigit]: http://www.cse.yorku.ca/~oz/ "Visit Ozan Yigit's homepage"

<!-- EOF -->
