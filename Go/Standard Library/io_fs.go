package main

/** untuk abtraksi filesystem
import "io/fs"

type File interface {
    Stat() (FileInfo, error)
    Read([]byte) (int, error)
    Close() error
}

type FileSystem interface {
    Open(name string) (File, error)
}

// Read file dari filesystem abstraction
func ReadFile(fsys fs.FS, name string) ([]byte, error)
*/