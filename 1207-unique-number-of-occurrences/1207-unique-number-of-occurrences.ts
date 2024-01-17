function uniqueOccurrences(arr: number[]): boolean {
  let m = new Map<number, number>();
  let s = new Set<number>();

  for (let i = 0; i < arr.length; i++) {
    m.set(arr[i], (!m.get(arr[i]) ? 0 : m.get(arr[i])) + 1);
  }

  m.forEach((value) => s.add(value));
  return m.size === s.size;
}
